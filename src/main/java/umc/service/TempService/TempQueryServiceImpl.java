package umc.service.TempService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import umc.apiPayload.code.status.ErrorStatus;
import umc.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

	@Override
	public void CheckFlag(Integer flag) {
		if (flag == 1)
			throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
	}
}
