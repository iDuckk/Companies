package com.example.companies.utils

import com.example.companies.model.DetailsCompany
import com.example.companies.presentation.fragmentDetails.DetailsCompanyViewModel
import com.google.gson.Gson
import javax.inject.Inject

class ParseJSON@Inject constructor() {

    operator fun invoke(json: String): DetailsCompany{
        var newStr = "" //Новая срока, куда будут добавлятся симовлы
        var openQuote = false //При открытии ковычек и закрытии ковычек

        //Создаем новую строку с добавлением экранирующих кавычек
        json.forEachIndexed { index, c ->
            //Проверяем строку на наличие служебных символов только в "Значении"
            if(c == '"' && json.get(index - 1) == ':'){
                openQuote = true //Открываем кавычки
                newStr += c  //Добавляем символ
            }else{
                if(openQuote){
                    if(c == '"'){
                        //Если "Значение" закрывается
                        if(json.get(index + 1) == ','
                            || json.get(index + 1) == '}'){
                            openQuote = false //Закрываем кавычки
                            newStr += c  //Добавляем символ
                        }else{
                            //Если кавычки в тексте
                            newStr += DetailsCompanyViewModel.ESCAPING_QUOTES//Добавляем экранирующие "\\"
                            newStr += c //Добавляем символ
                        }
                    }else{
                        newStr += c  //Добавляем символ
                    }
                }else{
                    newStr += c  //Добавляем символ
                }
            }
        }

        return Gson().fromJson(newStr, Array<DetailsCompany>::class.java).get(0)
    }

}