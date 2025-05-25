package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/me/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private User getUserFromToken(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        String username = jwtUtil.getUsernameFromToken(token);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping
    public ResponseEntity<?> getAllPosts(@RequestHeader("Authorization") String token) {
        User user = getUserFromToken(token);
        return ResponseEntity.ok(postRepository.findByUser(user));
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestHeader("Authorization") String token, 
                                      @RequestBody Post post) {
        User user = getUserFromToken(token);
        post.setUser(user);
        return ResponseEntity.ok(postRepository.save(post));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePost(@RequestHeader("Authorization") String token,
                                      @PathVariable Long id,
                                      @RequestBody Post postDetails) {
        User user = getUserFromToken(token);
        
        if (!postRepository.existsByIdAndUser(id, user)) {
            return ResponseEntity.notFound().build();
        }

        return postRepository.findById(id)
                .map(post -> {
                    if (postDetails.getTitle() != null) {
                        post.setTitle(postDetails.getTitle());
                    }
                    if (postDetails.getContent() != null) {
                        post.setContent(postDetails.getContent());
                    }
                    return ResponseEntity.ok(postRepository.save(post));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@RequestHeader("Authorization") String token,
                                      @PathVariable Long id) {
        User user = getUserFromToken(token);
        
        if (!postRepository.existsByIdAndUser(id, user)) {
            return ResponseEntity.notFound().build();
        }

        return postRepository.findById(id)
                .map(post -> {
                    postRepository.delete(post);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
