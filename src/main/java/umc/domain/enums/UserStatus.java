package umc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    ACTIVE("활성화"), 
    INACTIVE("비활성화");

    private final String description;
}
