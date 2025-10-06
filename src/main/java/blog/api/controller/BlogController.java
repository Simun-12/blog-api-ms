package blog.api.controller;

import blog.api.model.Blog;
import blog.api.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Blog API", description = "Operations related to blog")
@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @Operation(summary = "Get all blogs")
    @GetMapping("/getAllBlogs")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @Operation(summary = "Get all blogs by User ID")
    @GetMapping("/getAllBlogsByUserId/{userId}")
    public List<Blog> getAllBlogsByUserId(@PathVariable String userId) {
        return blogService.getAllBlogsByUserId(userId);
    }

    @Operation(summary = "Create Blog")
    @PostMapping("/createBlog")
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @Operation(summary = "Delete blog by ID")
    @DeleteMapping("/deleteBlog/{postId}")
    public void deleteBlog(@PathVariable String postId) {
        blogService.deleteBlog(postId);
    }

    @Operation(summary = "Delete all blogs by User ID")
    @DeleteMapping("/deleteAllBlogsByUser/{userId}")
    public void deleteAllBlogsByUser(@PathVariable String userId) {
        blogService.deleteAllBlogsByUser(userId);
    }

    @Operation(summary = "Update blog")
    @PutMapping("updateBlog/{postId}")
    public Blog updateBlog(@PathVariable String postId, @RequestBody Blog updatedBlog) {
        return blogService.updateBlog(postId, updatedBlog);
    }
}
