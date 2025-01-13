package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<PostDTO> index() {

        var posts = postRepository.findAll();
        return posts.stream()
                .map(this::getPostDTO)
                .toList();
    }


    @GetMapping("/{id}")
    public PostDTO show(@PathVariable long id) {

        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        return getPostDTO(post);

    }

    private PostDTO getPostDTO(Post post) {

            PostDTO postDTO = new PostDTO();
            var comments = commentRepository.findByPostId(post.getId());
            postDTO.setId(post.getId());
            postDTO.setTitle(post.getTitle());
            postDTO.setBody(post.getBody());
            postDTO.setComments(comments.stream()
                    .map(y -> {
                        CommentDTO commentDTO = new CommentDTO();
                        commentDTO.setId(y.getId());
                        commentDTO.setBody(y.getBody());
                        return commentDTO;
                    })
                    .toList());
            return postDTO;

    }

}
// END
