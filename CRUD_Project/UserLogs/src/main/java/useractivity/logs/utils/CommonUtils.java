package useractivity.logs.utils;

import org.springframework.stereotype.Component;
import useractivity.logs.dto.ApiResponse;
import useractivity.logs.dto.ErrorResponseDto;

@Component
public class CommonUtils {

		public ApiResponse<?> setApiResponses(Object data, String message, boolean b) {
		
		ApiResponse<Object> apiResponse = new ApiResponse<>();
		apiResponse.setMessage(message);

		apiResponse.setData(data);
		
		apiResponse.setSuccess(b);
		return apiResponse;
	}
	
	public ErrorResponseDto setErrorResponse(String message, boolean b) {
		ErrorResponseDto errorResponse = new ErrorResponseDto();
		errorResponse.setMessage(message);
		errorResponse.setSuccess(b);
		
		return errorResponse;
		
	}
}
