package com.pjys.board.controller;

import com.pjys.board.dto.BoardDTO;
import com.pjys.board.dto.CreateBoardRequest;
import com.pjys.board.dto.CreatePostRequest;
import com.pjys.board.dto.PostDTO;
import com.pjys.board.service.BoardService;
import com.pjys.board.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    @Autowired
    private final PostService postService;

    /**
     * 게시글 단건 조회
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/post/{id}")
    public String postDetail(Model model, @PathVariable long id) {
        PostDTO post = postService.getPost(id);
        model.addAttribute("post", post);
        return "/board/post";
    }

    /**
     * 게시글 작성
     * @param model
     * @param createPost
     * @return
     */
    @PostMapping("/post/write")
    public String postAdd(Model model, CreatePostRequest createPost) {
        createPost.setUserName("이연희");
        createPost.setUserId("lyh0208");
        Long newPostId = postService.createPost(createPost);
        return "redirect:/post/"+newPostId;
    }

    /**
     * 게시글 작성 폼 조회
     * @param model
     * @return
     */
    @GetMapping("/post/writeForm")
    public String postWriteForm(Model model) {
        return "/board/post_form";
    }

    /**
     * 게시글 목록 조회
     * @param model
     * @return
     */
    @GetMapping("/posts")
    public String boardList(Model model) {
        List<PostDTO> postList = postService.postList();
        model.addAttribute("postList", postList);

        return "/board/post_list";
    }
}
