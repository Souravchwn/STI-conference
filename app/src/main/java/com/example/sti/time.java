package com.example.sti;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class time {


    private static Date date1, date2;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws ParseException {
        List<String> list = new ArrayList<String>();
        list.add("08:30 AM - 09:30 AM");
        list.add("09:30 AM - 10:15 AM");
        list.add("10:15 AM - 11:00 AM");
        list.add("11:00 AM - 11:15 AM");
        list.add("11:15 AM - 12:00 PM");
        list.add("12:00 PM - 01:00 PM");
        list.add("12:00 PM - 01:00 PM");
        list.add("12:00 PM - 01:00 PM");
        list.add("01:00 PM - 02:00 PM");
        list.add("02:00 PM - 02:45 PM");
        list.add("02:45 PM - 03:30 PM");
        list.add("03:30 PM - 04:30 PM");
        list.add("03:30 PM - 04:45 PM");
        list.add("03:30 PM - 04:45 PM");
        list.add("03:30 PM - 04:45 PM");
        list.add("04:45 PM - 05:15 PM");
        list.add("05:15 PM - 05:45 PM");
        list.add("05:45 PM - 06:15 PM");
        list.add("06:15 PM - 07:00 PM");

        List<String> nextlist = new ArrayList<String>();

        nextlist.add("08:30 AM - 09:00 AM");
        nextlist.add("09:00 AM - 09:45 AM");
        nextlist.add("09:45 AM - 10:30 AM");
        nextlist.add("10:30 AM - 10:45 AM");
        nextlist.add("10:45 AM - 12:00 PM");
        nextlist.add("10:45 AM - 12:00 PM");
        nextlist.add("10:45 AM - 12:00 PM");
        nextlist.add("10:45 AM - 12:00 PM");
        nextlist.add("12:00 PM - 01:15 PM");
        nextlist.add("12:00 PM - 01:15 PM");
        nextlist.add("12:00 PM - 01:15 PM");
        nextlist.add("12:00 PM - 01:15 PM");
        nextlist.add("01:15 PM - 02:00 PM");
        nextlist.add("02:00 PM - 05:00 PM");
        nextlist.add("02:00 AM - 03:30 AM");
        nextlist.add("03:30 PM - 04:15 PM");
        nextlist.add("04:15 PM - 04:30 PM");
        nextlist.add("04:30 PM - 05:15 PM");
        nextlist.add("05:15 PM - 06:30 PM");
        nextlist.add("06:30 PM - 07:30 PM");

        List<String> linklist = new ArrayList<String>();

        linklist.add("No link");
        linklist.add("https://zoom.us/j/6511121930");
        linklist.add("https://zoom.us/j/6511121930");
        linklist.add("No link");
        linklist.add("https://zoom.us/j/6511121930");
        linklist.add("https://bdren.zoom.us/j/65935378694");
        linklist.add("https://bdren.zoom.us/j/62801855917");
        linklist.add("https://bdren.zoom.us/j/67158201124");
        linklist.add("No link");
        linklist.add("https://zoom.us/j/6511121930");
        linklist.add("https://zoom.us/j/6511121930");
        linklist.add("https://zoom.us/j/6511121930");
        linklist.add(" https://bdren.zoom.us/j/61614171981");
        linklist.add(" https://bdren.zoom.us/j/67666027328");
        linklist.add("https://bdren.zoom.us/j/67749203976");
        linklist.add("https://zoom.us/j/6511121930");
        linklist.add("No link");
        linklist.add("https://zoom.us/j/6511121930");
        linklist.add("No link");

        List<String> nlinklist = new ArrayList<String>();
        nlinklist.add("No link");
        nlinklist.add("https://zoom.us/j/6511121930");
        nlinklist.add("https://zoom.us/j/6511121930");
        nlinklist.add("No link");
        nlinklist.add("https://bdren.zoom.us/j/61734889690");
        nlinklist.add("https://bdren.zoom.us/j/67313954161");
        nlinklist.add("https://bdren.zoom.us/j/67370813880");
        nlinklist.add("https://bdren.zoom.us/j/68818793374");

        nlinklist.add("https://bdren.zoom.us/j/62277318121");
        nlinklist.add("https://bdren.zoom.us/j/65634636348");
        nlinklist.add("https://bdren.zoom.us/j/62501062127");
        nlinklist.add("https://bdren.zoom.us/j/65509603175");
        nlinklist.add("No link");
        nlinklist.add("https://bdren.zoom.us/j/64246365526");
        nlinklist.add("https://bdren.zoom.us/j/68184109978");
        nlinklist.add("https://zoom.us/j/6511121930");
        nlinklist.add("No link");
        nlinklist.add("https://zoom.us/j/6511121930");
        nlinklist.add("No link");
        nlinklist.add("https://zoom.us/j/6511121930");

        List<String> namelist = new ArrayList<String>();
        namelist.add("Conference Highlights and Greeting Exchanges");
        namelist.add("Inaugural Session");
        namelist.add("Keynote 01:Securing Cyber-Physical and IoT Systems in Smart Living Environments");
        namelist.add("Health Break");
        namelist.add("Keynote 02:Clone detection and Benchmarking in Big Code");
        namelist.add("Parallel Session 1: Computer Vision and Pattern Recognition");
        namelist.add("Parallel Session 2: Computational Linguistic and Natural Language ");
        namelist.add("Parallel Session 3: Advances in device and sensor technology");
        namelist.add("Prayer and Lunch Break");
        namelist.add("Keynote 03:Electrification in the Aerospace Industry");
        namelist.add("Keynote 04:Challenges and opportunities of Solar PV integrations to national grid");
        namelist.add("STI EXPO 2021: Required Technological Transition to Achieve Sustainable Development for Emerging Economy");
        namelist.add("Parallel Session 1: Artificial Intelligence and Machine Learning  ");
        namelist.add("Parallel Session 2: Deep Learning, Image Processing, Medical Imaging");
        namelist.add("Parallel Session 3: Systems & Security");
        namelist.add("Keynote 05:Silica composite microcapsules for functional finishing of textiles: encapsulation and release properties");
        namelist.add("Prayer and Health Break");
        namelist.add("Invited Talk 01:Functionalisation of fibre-reinforced plastic composites.");
        namelist.add("Advisory and Organizing");
        namelist.add("Committee Meeting");

        List<String> n_namelist = new ArrayList<String>();

        n_namelist.add("Conference Highlights and Greeting Exchanges");
        n_namelist.add("Keynote 06:Challenges in Real-time Edge AI");
        n_namelist.add("Keynote 07:Reliable Sensing with Unreliable Sensors: Reimaging the Possibilities and Redefining the Limits");
        n_namelist.add("Health Break");
        n_namelist.add("Parallel Session 1: Wireless and Mobile Networking  ");
        n_namelist.add("Parallel Session 2: Signal processing applications for Industry 4.0");
        n_namelist.add("Parallel Session 3: Efficient design in Control and Power Systems ");
        n_namelist.add("Parallel Session 4: Power Electronics for smart applications");
        n_namelist.add("Parallel Session 1: HCI, Algorithms, and Blockchain");
        n_namelist.add("Parallel Session 2: IoT and Cloud Computing:   ");
        n_namelist.add("Parallel Session 3: Renewable Energy & Sustainability ");
        n_namelist.add("Parallel Session 4: Textile Engineering Applications");
        n_namelist.add("Prayer and Health Break");
        n_namelist.add("Workshop on Healthcare Challenges based IoT Sensors & Video");
        n_namelist.add("Interactive Poster Session");
        n_namelist.add("Keynote 08:Pushing Intelligence to the Edge of Internet of Things: A new Paradigm enabling Next-Generation Smart Systems of Systems");
        n_namelist.add("Health Break");
        n_namelist.add("Keynote 09:Edge Intelligence for B5G/6G and IoT");
        n_namelist.add("Prayer Break and Socialization");
        n_namelist.add("Award Giving Ceremony ");


        Boolean nextday = false;
        SimpleDateFormat sdfd = new SimpleDateFormat("d");
        String date = sdfd.format(new Date());
        int match_time;
        int match_time_next;


        if (date.contains("16")) {
            //System.out.println("hell yeah i did it");
            System.out.println(list.get(5));

            int count = 0;
            Boolean parallel = false;
            for (String i : list) {
                String start = i.substring(0, 8);
                String end = i.substring(11, 19);

                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                String currentDateandTime = sdf.format(new Date());


                try {
                    //
                    String string1 = start;
                    Date time1 = new SimpleDateFormat("hh:mm a").parse(string1);
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(time1);
                    calendar1.add(Calendar.DATE, 1);


                    String string2 = end;
                    Date time2 = new SimpleDateFormat("hh:mm a").parse(string2);
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTime(time2);
                    calendar2.add(Calendar.DATE, 1);

                    // String someRandomTime = currentDateandTime;
                    String someRandomTime = "12:01 PM";
                    Date d = new SimpleDateFormat("hh:mm a").parse(someRandomTime);
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.setTime(d);
                    calendar3.add(Calendar.DATE, 1);

                    Date x = calendar3.getTime();
                    if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                        //checkes whether the current time is between
                        match_time = list.indexOf(i);
                        // match_time+=1;
                        System.out.println("This is in time" + match_time);
                        System.out.println(linklist.get(match_time));
                        System.out.println(namelist.get(match_time));

                        if (match_time == 5) {
                            System.out.println("Detechted the parallel");
                            System.out.println(namelist.get(12));

                        }
                        if (match_time == 12) {

                        }
                        break;
                    }


                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }


        } else {
            for (String i : list) {
                String start = i.substring(0, 8);
                String end = i.substring(11, 19);

                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                String currentDateandTime = sdf.format(new Date());


                try {
                    //
                    String string1 = start;
                    Date time1 = new SimpleDateFormat("hh:mm a").parse(string1);
                    Calendar calendar1 = Calendar.getInstance();
                    calendar1.setTime(time1);
                    calendar1.add(Calendar.DATE, 1);


                    String string2 = end;
                    Date time2 = new SimpleDateFormat("hh:mm a").parse(string2);
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTime(time2);
                    calendar2.add(Calendar.DATE, 1);

                    // String someRandomTime = currentDateandTime;
                    String someRandomTime = "12:01 PM";
                    Date d = new SimpleDateFormat("hh:mm a").parse(someRandomTime);
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.setTime(d);
                    calendar3.add(Calendar.DATE, 1);

                    Date x = calendar3.getTime();
                    if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                        //checkes whether the current time is between
                        match_time = list.indexOf(i);
                        // match_time+=1;
                        System.out.println("This is in time" + match_time);
                        System.out.println(linklist.get(match_time));
                        System.out.println(namelist.get(match_time));

                        if (match_time == 5) {
                            System.out.println("Detechted the parallel");
                            System.out.println(namelist.get(12));

                        }
                        if (match_time == 12) {

                        }
                        break;
                    }


                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }


        }
    }
}
