package by.krivosheev.interview_manager.core.client

import by.krivosheev.interview_manager.core.dto.RangeDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

/**
 * Класс взаимодействия с Google таблицами по API.
 */
@FeignClient(
    name = "googleSheetsClient",
    url = "https://sheets.googleapis.com/v4/spreadsheets",
)
interface GoogleSheetsClient {

    /**
     * Получить все данные по заданному вкладке и диапазону.
     *
     * @param spreadsheetId идентификатор Google таблицы
     * @param range название вкладки с диапазоном
     * @param key ключ
     */
    @GetMapping("/{spreadsheetId}/values/{range}")
    fun getValues(
        @PathVariable("spreadsheetId")
        spreadsheetId: String,
        @PathVariable("range")
        range: String,
        @RequestParam("key")
        key: String
    ): RangeDto
}
