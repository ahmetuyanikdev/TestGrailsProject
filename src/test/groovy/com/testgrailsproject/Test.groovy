package com.testgrailsproject

import groovy.transform.EqualsAndHashCode
import org.hibernate.validator.constraints.NotEmpty

import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.xml.bind.DatatypeConverter

class Test {

   public static void main(String[] args){
       Test t = new Test()
       /*while(true){
           String s = t.getHTML('http://www.kurdistaninvestment.org/')
           println('--------//////-------')
           println(s)
       }*/

       Person p = t.createSample()
       t.printSample(p)

      // String timeZone = 'America/Tijuana (−08:00)'
       //String timeZone = 'Europe/Paris (+01:00)'
       String timeZone = 'Europe/Paris (-11:00)'
       int hourStartingIndex = getIndexOfSign(timeZone)
       String s=timeZone.substring(hourStartingIndex,hourStartingIndex+3)
       println(s)
       int parsed

       try{
           parsed = Integer.valueOf(s)
       }
       catch (Exception e){
           parsed = 0
       }

       println(parsed)
       println("------")

       println(new Date())

    }

    static  int  getIndexOfSign(String timeZone){
        int signIndex=0
        if(timeZone.contains('(')){
            signIndex = timeZone.indexOf('(')+1
        }
        signIndex
    }

    void printSample(@Valid Person person){
        println('--- name '+person.name)
        println('---- age '+person.age)
    }

    Person createSample(){
        Person person = new Person()
        person
    }



    class MyThread extends Thread{
        String uri
        @Override
        public void run(){
            while (true){
                String s =getHTML(uri)
                println('--------///Thread///-------')
                println(s)
            }
        }
    }

    void initializeAndRunTread(String uri){
        MyThread myThread = new MyThread()
        myThread.start()
    }


    public String getHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        StringBuilder result = new StringBuilder();
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
