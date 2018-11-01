package com.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class OraclePackgeUtils {
    public static Logger log = LoggerFactory.getLogger(OraclePackgeUtils.class);

    public String  saveMNPItem(MNPItemDTO mnpItem){
        Connection con = DBUtils.getConnection();
        if(con == null){
            return  "-1";
        }
        //
        CallableStatement cstmt = null;
        try {
            cstmt = con.prepareCall("{? = call pkg_mnp.f_save_mnp(?,?,?)}");
            cstmt.registerOutParameter(1, Types.VARCHAR);
            cstmt.setString(2, mnpItem.getMsisdn());
            cstmt.setInt(3, Integer.parseInt(mnpItem.getCurrentParticipant()));
            //
            String subType = mnpItem.getSubType();
            if (!Utils.isStringNullOrEmpty(subType)) {
                cstmt.setInt(4, Integer.parseInt(mnpItem.getSubType()) );
            }else{
                cstmt.setInt(4, -1 );

            }
            //
            cstmt.execute();
            String callDbResult = cstmt.getString(1);
            //
            return callDbResult;
            //
        } catch (SQLException e) {
            e.printStackTrace();
            return  "-1";
        } finally {
            DBUtils.closeConnection(cstmt,con);
        }
    }
}
