package org.haiykut.libraryy.controllers;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.entities.Officer;
import org.haiykut.libraryy.services.abstracts.MemberService;
import org.haiykut.libraryy.services.dtos.MemberForAddDto;
import org.haiykut.libraryy.services.dtos.OfficerForAddDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public List<Member> getAll(){
        return memberService.getAll();
    }
    @GetMapping("/{memberId}")
    public Member getOneMember(@PathVariable int memberId) {
        return memberService.getById(memberId);
    }
    @PostMapping
    public void add(@RequestBody MemberForAddDto dto)
    {
        memberService.add(dto);
    }

    @DeleteMapping ("/{memberId}")
    public void deleteOneMember(@PathVariable int officerId) {
        memberService.delete(officerId);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable int id, @RequestBody MemberForAddDto newMember)
    {
        try {
            memberService.update(id,newMember);
        } catch (Exception e) {
            throw new RuntimeException("Error updating member: " + e.getMessage());
        }
    }
}
