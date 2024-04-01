package org.haiykut.libraryy.controllers;

import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Member;
import org.haiykut.libraryy.services.abstracts.MemberService;
import org.haiykut.libraryy.services.dtos.requests.member.MemberAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.member.MemberUpdateRequestDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberAddResponseDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberGetDto;
import org.haiykut.libraryy.services.dtos.responses.Member.MemberUpdateResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/all")
    public List<MemberGetDto> getAll(){
        return memberService.getAllMembers();
    }
    @GetMapping("/{memberId}")
    public MemberGetDto getOneMember(@PathVariable int memberId) {
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
    public MemberUpdateResponseDto updateMember(@PathVariable int id, @RequestBody MemberUpdateRequestDto newMember)
    {
        try {
            return memberService.updateById(id, newMember);
        } catch (Exception e) {
            throw new RuntimeException("Error updating member: " + e.getMessage());
        }
    }
}
