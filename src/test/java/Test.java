import com.utils.common.JSONUtils;
import com.utils.dto.RESPONSE;

public class Test {
    public static void main(String[] args) {
//        SHAPE_CIRCLE_CENTER shape_circle_center1 = new SHAPE_CIRCLE_CENTER("lat1", "long1");
//        SHAPE_CIRCLE_CENTER shape_circle_center2 = new SHAPE_CIRCLE_CENTER("lat2", "long2");
//        List<SHAPE_CIRCLE_CENTER> lstCircle = new ArrayList<SHAPE_CIRCLE_CENTER>();
//        lstCircle.add(shape_circle_center1);
//        lstCircle.add(shape_circle_center2);
//        SHAPE_CIRCLE shape_circle = new SHAPE_CIRCLE("1", lstCircle);
//        LBARequest request = new LBARequest("abcd", "requestid", shape_circle);
//        System.out.println(JSONUtils.object2JSONString(request));

        RESPONSE Re = new RESPONSE("0","","200","150");
        System.out.println(JSONUtils.object2JSONString(Re));
    }
}
