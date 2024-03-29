package org.haiykut.libraryy.repositories;

import org.haiykut.libraryy.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
