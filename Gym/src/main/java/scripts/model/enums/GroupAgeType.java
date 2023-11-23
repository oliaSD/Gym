package scripts.model.enums;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;


public enum GroupAgeType {
    Child, Teen, Youth, Adult, Old, Unknow;

    
    private  static final Set<Range> range  = Set.of(
        new Range(0,12,GroupAgeType.Child)
        , new Range(13, 16, Teen)
        , new Range(22, 50, Adult)
        , new Range(51, Integer.MAX_VALUE, Old)
        );
    
    public GroupAgeType getGroupAgeTypeByBirhDay(Date birthDay){
        
        for (var elem : range) {
            if(elem.inThisRange(Period.between(LocalDate.now(),birthDay.toLocalDate()).getYears())){
                return elem.groupAgeType();
            }
        }
        return Old;
    }
}

record Range(Integer Min, Integer Max, GroupAgeType groupAgeType) {

        public boolean inThisRange(Integer o){
                if(o>this.Min && o < this.Max){
                    return true;
                }
                return false;
        }
    
    }

