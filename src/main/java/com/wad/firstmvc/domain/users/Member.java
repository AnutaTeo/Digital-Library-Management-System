package com.wad.firstmvc.domain.users;

import lombok.Getter;

public class Member {
    @Getter
    private final Long id; @Getter
    private final String email; private final String name;
    public Member(Long id, String email, String name){
        this.id=id;
        this.email=email;
        this.name=name;
    }

}
