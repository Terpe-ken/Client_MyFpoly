package com.example.myapplication2.Helper;

import com.example.myapplication2.dto.CosoRequestDTO;
import com.example.myapplication2.dto.CosoResponeseDTO;
import com.example.myapplication2.dto.GetCourseIdRequestDTO;
import com.example.myapplication2.dto.GetCourseIdResponeseDTO;
import com.example.myapplication2.dto.GetLichHocIdRequestDTO;
import com.example.myapplication2.dto.GetLichHocIdResponeseDTO;
import com.example.myapplication2.dto.GetLichThiIdRequestDTO;
import com.example.myapplication2.dto.GetLichThiIdResponeseDTO;
import com.example.myapplication2.dto.GetNewsKeywordRequestDTO;
import com.example.myapplication2.dto.GetNewsKeywordResponeseDTO;
import com.example.myapplication2.dto.GetnewsIdRequestDTO;
import com.example.myapplication2.dto.GetnewsIdResponeseDTO;
import com.example.myapplication2.dto.ListGetAllCourseResponeseDTO;
import com.example.myapplication2.dto.ListGetAllLichHocRequestDTO;
import com.example.myapplication2.dto.ListGetAllLichHocResponeseDTO;
import com.example.myapplication2.dto.ListGetAllLichThiRequestDTO;
import com.example.myapplication2.dto.ListGetAllLichThiResponeseDTO;
import com.example.myapplication2.dto.ListGetAllNewsResponeseDTO;
import com.example.myapplication2.dto.ListGetAllThongBaoRequestDTO;
import com.example.myapplication2.dto.ListgetAllCosoResponeseDTO;
import com.example.myapplication2.dto.ListgetAllThongBaoResponeseDTO;
import com.example.myapplication2.dto.LoginRequestDTO;
import com.example.myapplication2.dto.LoginResponeseDTO;
import com.example.myapplication2.dto.RegisterRequestDTO;
import com.example.myapplication2.dto.RegisterResponeseDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IRetrofit {
    @POST("/api/register.php")
    Call<RegisterResponeseDTO> register(@Body RegisterRequestDTO body);

    @POST("/api/login.php")
    Call<LoginResponeseDTO> login(@Body LoginRequestDTO body);

    @GET("/api/getallnews.php")
    Call<ListGetAllNewsResponeseDTO> getallnews();

    @POST("/api/getnewsid.php")
    Call<GetnewsIdResponeseDTO> getNewsId(@Body GetnewsIdRequestDTO body);

    @GET("/api/getallcourse.php")
    Call<ListGetAllCourseResponeseDTO> getallcourse();

    @POST("/api/getcourseid.php")
    Call<GetCourseIdResponeseDTO> getCourseId(@Body GetCourseIdRequestDTO body);

    @POST("/api/getalllichhoc.php")
    Call<ListGetAllLichHocResponeseDTO> getAllLichHoc(@Body ListGetAllLichHocRequestDTO body);

    @POST("/api/getlichhocid.php")
    Call<GetLichHocIdResponeseDTO> getLichHocId(@Body GetLichHocIdRequestDTO body);

    @POST("/api/getalllichthi.php")
    Call<ListGetAllLichThiResponeseDTO> getAllLichThi(@Body ListGetAllLichThiRequestDTO body);

    @POST("/api/getlichthiid.php")
    Call<GetLichThiIdResponeseDTO> getLichThiId(@Body GetLichThiIdRequestDTO body);

    @POST("/api/cosonn.php")
    Call<CosoResponeseDTO> getCoSonn(@Body CosoRequestDTO body);

    @GET("/api//getallcoso.php")
    Call<ListgetAllCosoResponeseDTO> getAllCoso();

    @POST("/api/getallthongbao.php")
    Call<ListgetAllThongBaoResponeseDTO> getallthongbao(@Body ListGetAllThongBaoRequestDTO body);

    @POST("/api/getnewskeyword.php")
    Call<GetNewsKeywordResponeseDTO> getnewskeyword(@Body GetNewsKeywordRequestDTO body);
}
