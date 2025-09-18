package ru.netology.personsapp.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secured")
public class SecuredController {


    @Secured("ROLE_READ")
    @GetMapping("/read")
    public ResponseEntity<String> getForRead() {
        return ResponseEntity.ok("Доступ для роли READ");
    }


    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/write")
    public ResponseEntity<String> getForWrite() {
        return ResponseEntity.ok("Доступ для роли WRITE");
    }


    @PreAuthorize("hasAnyRole('WRITE','DELETE')")
    @GetMapping("/write-or-delete")
    public ResponseEntity<String> getForWriteOrDelete() {
        return ResponseEntity.ok("Доступ для ролей WRITE или DELETE");
    }


    @GetMapping("/username")
    public ResponseEntity<String> getForUsername(@RequestParam String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        if (currentUserName.equals(username)) {
            return ResponseEntity.ok("Доступ для пользователя: " + username);
        } else {
            return ResponseEntity.status(403).body("Доступ запрещён: несовпадение username");
        }
    }
}