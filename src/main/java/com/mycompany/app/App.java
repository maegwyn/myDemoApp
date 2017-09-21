package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static ArrayList<String> myMethod(ArrayList<String> array, int e, ArrayList<String> a) {
      System.out.println("inside search");
      if (array == null){
	  	for(int i = 0;i<a.size();i++)
			array.add(a.get(i));
	  }

		int count = 0;
	  for(String elt2 : array){
		  count++;
	  }
		
      for (String elt : array) {
        if (count == e) array.add("TRUE");
      }
      return array;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          System.out.println(req.queryParams("input1"));
          System.out.println(req.queryParams("input2"));
          System.out.println(req.queryParams("input3"));

			
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList = new java.util.ArrayList<String>();
          while (sc1.hasNext())
          {
            String value = sc1.next().replaceAll("\\s","");
            inputList.add(value);
          }
          System.out.println(inputList);

          String input3 = req.queryParams("input3");
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList3 = new java.util.ArrayList<String>();
          while (sc1.hasNext())
          {
            String value3 = sc1.next().replaceAll("\\s","");
            inputList3.add(value3);
          }
          System.out.println(inputList3);
			
			

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);

          ArrayList <String> fullList = App.myMethod(inputList, input2AsInt,inputList3);

		  boolean result = false;
		  if(fullList.get(fullList.size()-1) == "TRUE"){	
			result = true;
		    fullList.remove(fullList.size()-1);		//removing the last element  if it is "True"			
		  }
			
         Map map = new HashMap();
          map.put("result", result);
		//  map.put("Full List: ",fullList);	
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute", (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
