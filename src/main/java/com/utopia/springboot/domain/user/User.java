package com.utopia.springboot.domain.user;

import com.utopia.springboot.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
}
