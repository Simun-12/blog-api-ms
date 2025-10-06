package blog.api.service;

import blog.api.model.Blog;
import blog.api.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public List<Blog> getAllBlogsByUserId(String userId) {
        return blogRepository.findByUserId(userId);
    }

    public Blog createBlog(Blog blog) {
        blog.setDateOfCreation(LocalDateTime.now());
        blog.setLastUpdated(LocalDateTime.now());
        return blogRepository.save(blog);
    }

    public void deleteBlog(String postId) {
        if (!blogRepository.existsById(postId)) {
            throw new RuntimeException("Blog not found with ID: " + postId);
        }
        blogRepository.deleteById(postId);
    }

    public void deleteAllBlogsByUser(String userId) {
        blogRepository.deleteBlogsByUserId(userId);
    }

    public Blog updateBlog(String postId, Blog updatedBlog) {
        Blog existingBlog = blogRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Blog not found with ID: " + postId));

        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setContent(updatedBlog.getContent());
        existingBlog.setLastUpdated(LocalDateTime.now());

        return blogRepository.save(existingBlog);
    }
}
