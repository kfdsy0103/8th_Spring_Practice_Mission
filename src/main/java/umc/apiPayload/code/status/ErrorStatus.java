package umc.apiPayload.code.status;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.apiPayload.code.BaseErrorCode;
import umc.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

	// 가장 일반적인 응답
	_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
	_BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
	_UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
	_FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

	// 멤버 관련 에러
	USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER4001", "사용자가 없습니다."),
	NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "USER4002", "닉네임은 필수 입니다."),
	EMAIL_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER4003", "해당 이메일의 사용자가 없습니다."),
	INVALID_PASSWORD(HttpStatus.NOT_FOUND, "USER4004", "비밀번호가 일치하지 않습니다."),

	// 예시
	ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

	// Temp Test
	TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

	// 음식 카테고리 관련 에러
	FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD4001", "음식 카테고리가 없습니다."),

	// 지역 관련 에러
	REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "해당 지역이 없습니다."),

	// 식당 관련 에러
	RESTAURANT_NOT_FOUND(HttpStatus.NOT_FOUND, "RESTAURANT4001", "식당이 존재하지 않습니다."),

	// 미션 관련 에러
	MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4001", "미션이 존재하지 않습니다."),
	ALREADY_CHALLENGE(HttpStatus.BAD_REQUEST, "MISSION4002", "이미 수행 중인 미션입니다."),
	USER_MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4003", "수행 중인 미션이 존재하지 않습니다."),

	// 토큰 관련 에러
	INVALID_TOKEN(HttpStatus.NOT_FOUND, "TOKEN4001", "토큰이 유효하지 않습니다."),

	// 페이징 관련 에러
	PAGE_NOT_VALID(HttpStatus.BAD_REQUEST, "PAGE4001", "페이징 번호가 유효하지 않습니다.");

	private final HttpStatus httpStatus;
	private final String code;
	private final String message;

	@Override
	public ErrorReasonDTO getReason() {
		return ErrorReasonDTO.builder()
			.message(message)
			.code(code)
			.isSuccess(false)
			.build();
	}

	@Override
	public ErrorReasonDTO getReasonHttpStatus() {
		return ErrorReasonDTO.builder()
			.message(message)
			.code(code)
			.isSuccess(false)
			.httpStatus(httpStatus)
			.build();
	}
}
