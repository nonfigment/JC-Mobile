/*
package com.redshift.jumpcalc;

//public class Logic {
        public void input() {
//           //Старая логика работы
//
//            //общая примерная дистанция между кораблями, до тех пор, пока кто-то из пилотов не начнет движение
//            int distance=5000;
//            //параметры прыжка для каждого из двух кораблей
//            int DBE_Jrange=15;
//            int BL_JRange=36;
//            //параметры времени работы стандартного FSD
//            //зарядка FSD
//            float FSD_charge=10;
//            //безопасное охлаждение FSD
//            float FSD_safecooling=10;
//            //прыжок с использованием FSD
//            float FSD_jumptime=15;
//            //суммируем все временные факторы работы FSD
//            float FSD_sum=FSD_charge+FSD_jumptime+FSD_safecooling;
//            //переводим секунды в минуты
//            float FSD_WTM=FSD_sum/60;
//            //и затем в часы
//            float FSD_WTH=FSD_WTM/60;
//            // итог - работа FSD
//            float FSD=FSD_WTH;
//            //дополнительные задержки
//            //заправка от звезды
//            float BLrefuel=20;
//            //переводим секунды в минуты
//            float BLR_M=BLrefuel/60;
//            //и затем в часы
//            float BLR_H=BLR_M/60;
//            // итог - задержки для BL
//            float BLR=BLR_H;
//            float DBErefuel=10;
//            //переводим секунды в минуты
//            float DBER_M=DBErefuel/60;
//            //и затем в часы
//            float DBER_H=DBER_M/60;
//            // итог - задержки для DBE
//            float DBER=DBER_H;
//            //облёт звезды, если цель скрыта ею
//            float escaperoute_s=15;
//            float escaperoute_m=escaperoute_s/60;
//            float escaperoute_h=escaperoute_m/60;
//            float escaperoute=escaperoute_h;
//            //суммируем дополнительные задержки
//            float delayDBE=DBER+escaperoute;
//            float delayBL=BLR+escaperoute;
//            //считаем время выполнения маршрута каждым кораблем для заданной дистанции
//            float DBE_RouteTime=(distance/DBE_Jrange)*(FSD+delayDBE);
//            float BL_RouteTime=(distance/BL_JRange)*(FSD+delayBL);
//
//            //проверка значений
//
//            //для DBE
//            if (DBE_RouteTime>0) {
//                System.out.println("Diamondback Explorer will bridge the distance of "+distance+" ly in "+DBE_RouteTime+" hours");
//            }
//            else {
//                System.out.println("Something went wrong, please, check your data and DBE FSD-related specs.");
//            }
//            //для BL
//            if (BL_RouteTime>0) {
//                System.out.println("Beluga Liner will bridge the distance of "+distance+" ly in "+BL_RouteTime+" hours");
//            }
//            else {
//                System.out.println("Something went wrong, please, check your data and BL FSD-related specs.");
            }
        }
*/
