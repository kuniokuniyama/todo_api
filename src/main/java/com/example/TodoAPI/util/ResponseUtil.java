package com.example.TodoAPI.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

    /**
     * Expiresヘッダーを設定したResponseEntityを生成します
     * 
     * @param <T> レスポンスボディの型
     * @param body レスポンスボディ
     * @param status HTTPステータス
     * @param minutes キャッシュ有効期間（分）
     * @return キャッシュヘッダー付きResponseEntity
     */
    public <T> ResponseEntity<T> createCacheableResponse(T body, HttpStatus status, int minutes) {
        HttpHeaders headers = new HttpHeaders();
        
        // HTTP日付フォーマッター
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        // 指定分後の日時を計算
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minutes);
        Date expiresDate = calendar.getTime();
        
        // ヘッダーの設定
        headers.set("Expires", dateFormat.format(expiresDate));
        // Cache-Controlを使用する場合はこちら（"Expires"と同時にセットした場合は"Cache-Control"が優先される）
        // headers.set("Cache-Control", "public, max-age=" + (minutes * 60));
        
        return new ResponseEntity<>(body, headers, status);
    }
    
    /**
     * デフォルト2分間のキャッシュを設定したResponseEntityを生成します
     * 
     * @param <T> レスポンスボディの型
     * @param body レスポンスボディ
     * @return キャッシュヘッダー付きResponseEntity
     */
    public <T> ResponseEntity<T> createCacheableResponse(T body) {
        return createCacheableResponse(body, HttpStatus.OK, 2);
    }
}
