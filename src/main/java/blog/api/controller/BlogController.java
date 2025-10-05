package blog.api.controller;


import blog.api.model.Blog;
import blog.api.repository.BlogRepository;
import blog.api.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    @Operation(summary = "Create Blogs")
    @PostMapping
    public Blog createBlog(@RequestBody Blog blog){
        return blogRepository.save(blog);
    }

    @Operation(summary = "Delete blog by ID")
    @DeleteMapping("/{postId}")
    public void deleteBlog(@PathVariable String postId){
        blogRepository.deleteById(postId);
    }

}
