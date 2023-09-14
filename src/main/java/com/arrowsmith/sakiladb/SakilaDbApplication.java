package com.arrowsmith.sakiladb;

import com.arrowsmith.sakiladb.entities.Film;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SakilaDbApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(SakilaDbApplication.class, args);
	}



}
