package org.haiykut.libraryy.controllers;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.services.abstracts.MemberService;
import org.haiykut.libraryy.services.dtos.requests.member.MemberAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.member.MemberUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberAddResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/all")
    public List<Member> getAll(){
        return memberService.getAllMembers();
    }
    @GetMapping("/{memberId}")
    public Member getOneMember(@PathVariable int memberId) {
        return memberService.getMemberById(memberId);
    }
    @PostMapping("/add")
    public MemberAddResponseDto add(@RequestBody MemberAddRequestDto dto){
        return memberService.add(dto);

    }
    @DeleteMapping ("/delete/{memberId}")
    public void deleteOneMember(@PathVariable int memberId) {
        memberService.deleteById(memberId);
    }

    @PutMapping("/update/{id}")
    public void updateMember(@PathVariable int id, @RequestBody MemberUpdateRequestDto newMember)
    {
        try {
            memberService.updateById(id,newMember);
        } catch (Exception e) {
            throw new RuntimeException("Error updating member: " + e.getMessage());
        }
    }
}
