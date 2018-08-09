package com.meng.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "VerifyServlet",urlPatterns = "/code")
public class VerifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width =100;
        int height =30;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.gray);
        graphics.fillRect(0,0,width,height);
        String str = "adscsdsa8878781";


        graphics.setColor(Color.black);
        for(int i =0;i<4;i++){
            Random r = new Random();
            int postion = r.nextInt(str.length());
            String randomStr = str.substring(postion,postion+1);
            graphics.drawString(randomStr,width/5*(i+1),15);
        }

        ImageIO.write(image,"jpg", response.getOutputStream());
    }
}
