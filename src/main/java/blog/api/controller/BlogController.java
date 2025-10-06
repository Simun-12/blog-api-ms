package blog.api.controller;


import blog.api.model.Blog;
import blog.api.repository.BlogRepository;
import blog.api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Blog API", description = "Operations related to blog" )
@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    private final BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    @Operation(summary = "Get all blogs")
    @GetMapping("/getAllBlogs")
    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    @Operation(summary = "Get all blogs by User ID")
    @GetMapping("/getAllBlogsByUserId/{userId}")
    public List<Blog> getAllBlogsByUserId(@PathVariable String userId){
        return blogRepository.findByUserId(userId);
    }

    @Operation(summary = "Create Blogs")
    @PostMapping("/createBlog")
    public Blog createBlog(@RequestBody Blog blog){
        return blogRepository.save(blog);
    }

    @Operation(summary = "Delete blog by ID")
    @DeleteMapping("/deleteBlog/{postId}")
    public void deleteBlog(@PathVariable String postId){
        blogRepository.deleteById(postId);
    }

    @Operation(summary = "Delete all blogs by User")
    @DeleteMapping("/deleteAllBlogsByUser/{userId}")
    public void deleteAllBlogsByUser(@PathVariable String userId){
        blogRepository.deleteBlogsByUserId(userId);
    }

    @PutMapping("/{postId}")
    public Blog updateBlog(@PathVariable String postId, @RequestBody Blog updatedBlog) {
        Blog existingBlog = blogRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Blog not found with ID: " + postId));

        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setContent(updatedBlog.getContent());
        existingBlog.setLastUpdated(LocalDateTime.now());

        return blogRepository.save(existingBlog);
    }

}
