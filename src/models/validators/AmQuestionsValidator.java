package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.AmQuestion;
import utils.DBUtil;

public class AmQuestionsValidator {
        public static List<String> validate(AmQuestion q,String filename,String filepath){
            List<String> errors = new ArrayList<String>();

            String year_error = validateYear(q.getQs_year());

            if(!year_error.equals("")){
                errors.add(year_error);
            }

            String number_error = validateNumber(q.getQs_number());

            if(!number_error.equals("")){
                errors.add(number_error);
            }

            String category_error = validateCategory(q.getCategory());

            if(!category_error.equals("")){
                errors.add(category_error);
            }

            String answer_error = validateAnswer(q.getAnswer());

            if(!answer_error.equals("")){
                errors.add(answer_error);
            }

            String content_error = validateContentCheck(q,filename,filepath);

            if(!content_error.equals("")){
                errors.add(content_error);
            }

            return errors;
        }

        private static String validateYear(String year){

            //出題時期の必須入力チェック
            if(year == null || year.equals("")){
                return "出題時期を選択してください";
            }
            return "";
        }

        private static String validateNumber(Integer number){

            //問題番号の必須入力チェック
            if(number == null || number.equals("")){
                return "問題番号を選択してください";
            }

            return "";
        }

        private static String validateCategory(Integer category){

            //問題の分野の必須入力チェック
            if(category == null || category.equals("")){
                return "問題カテゴリを入力してください";
            }

            return "";
        }

        private static String validateAnswer(Integer answer){

            //問題の分野の必須入力チェック
            if(answer == null || answer.equals("")){
                return "答えを入力してください";
            }

            return "";
        }

        //問題を初めて登録(create)するときのみ呼び出す。編集(edit)だとややこしくなるため。
        private static String validateContentCheck(AmQuestion q,String filename,String filepath){
           //問題の出題時期、番号が未入力の場合、エラーメッセージを返す
           if(q.getQs_year()!=null && q.getQs_season()!=null && q.getQs_number()!=null){
            EntityManager em = DBUtil.createEntityManager();
            //登録する問題が既にテーブルへ登録されているかチェック
            long quploaded = (long)em.createNamedQuery("getUploadedQuestion",Long.class)
                    .setParameter("qs_year", q.getQs_year())
                    .setParameter("qs_season", q.getQs_season())
                    .setParameter("qs_number", q.getQs_number())
                    .getSingleResult();

            em.close();

            if(quploaded > 0){
                return "既に登録済みの問題です";
            }

            /*登録する問題の画像がアップロードされているかチェック
             * heroku環境でのアップロードが上手くいかないため断念
            File dir = new File(filepath);
            File[] list = dir.listFiles();

            for(int i=0;i < list.length; i++){
                if(list[i].getName().contains(filename) && q.getQs_number()!=null){
                    return "";
                }
            }

            return "問題内容がアップロードされていません"; */
           }
           return "";
        }
}
