package com.github.books.handlers;

import com.github.books.controller.ControllerImpl;
import com.github.books.dto.AuthorDto;
import com.github.books.dto.AuthorIdRequest;
import com.github.books.dto.BookDto;
import com.github.books.dto.PartOfBookNameDto;
import com.github.books.entities.Author;
import com.github.books.exceptions.BadRequest;
import com.github.books.exceptions.NotFound;
import com.github.books.utils.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HttpHandler extends HttpServlet {

    private final ControllerImpl controller;

    public HttpHandler(ControllerImpl controller) {
        this.controller = controller;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        } catch (BadRequest e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid body");
        } catch (NotFound e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "NOT FOUND 404");
        }

    }

    @Override
    public void doOptions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        req.setCharacterEncoding("UTF-8");
        String body = req.getReader().lines().collect(Collectors.joining());
        if (!"application/json".equalsIgnoreCase(req.getHeader("Content-Type"))) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid content type");
        } else {
            String url = req.getRequestURI();
            try(ServletOutputStream out = resp.getOutputStream()) {
                switch (url) {
                    case "/createauthor":
                        AuthorDto authorDto = JsonParser.fromJson(body, AuthorDto.class).orElseThrow(BadRequest::new);
                        if (authorDto == null) {
                            throw new BadRequest("Author info cannot be empty");
                        }
                        this.controller.createAuthor(authorDto);
                        resp.setStatus(HttpServletResponse.SC_OK);
                        break;
                    case "/createbook":
                        BookDto bookDto = JsonParser.fromJson(body, BookDto.class).orElseThrow(BadRequest::new);
                        if(bookDto == null) {
                            throw new BadRequest("Book info cannot be empty");
                        }
                        this.controller.createBook(bookDto);
                        resp.setStatus(HttpServletResponse.SC_OK);
                        break;
                    case "/updateauthorbyid":
                        //TODO update author(should works like creating)
                        break;
                    case "/getauthorbyid":
                        AuthorIdRequest authorId = JsonParser.fromJson(body, AuthorIdRequest.class).orElseThrow(BadRequest::new);
                        if(authorId == null) {
                            throw new BadRequest("Author id is Null");
                        }
                        Author authorResult = this.controller.getAuthorById(authorId.getAuthorId());
                        resp.setContentType("application/json");
                        resp.setStatus(HttpServletResponse.SC_OK);
                        out.write(JsonParser.toJson(authorResult).get().getBytes());
                        break;
                    case "/getbypartofbookname":
                        PartOfBookNameDto part = JsonParser.fromJson(body, PartOfBookNameDto.class).orElseThrow(BadRequest::new);
                        if (part == null) {
                            throw new BadRequest("Bad request");
                        }
                        List<Long> idList = this.controller.getAuthorIdByPartOfBookName(part.getBookName());
                        resp.setContentType("application/json");
                        resp.setStatus(HttpServletResponse.SC_OK);
                        out.write(JsonParser.toJson(idList).get().getBytes());
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
