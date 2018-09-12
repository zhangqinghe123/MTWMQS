package com.qianxx.qztaxi.service.impl;

import com.qianxx.qztaxi.common.CommonUtils;
import com.qianxx.qztaxi.common.ErrCodeConstants;
import com.qianxx.qztaxi.common.exception.RestServiceException;
import com.qianxx.qztaxi.common.util.Constants;
import com.qianxx.qztaxi.common.util.DateUtil;
import com.qianxx.qztaxi.dao.service.StPptnRDao;
import com.qianxx.qztaxi.po.StPptnR;
import com.qianxx.qztaxi.po.StStbprpB;
import com.qianxx.qztaxi.service.StPptnRService;
import com.qianxx.qztaxi.service.StStbprpBService;
import com.qianxx.qztaxi.vo.SiteRainInfo;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 *
 * @Auther: 张庆贺
 * @Date: 2018/9/11 16:02
 */
@Service("stPptnRService")
public class StPptnRServiceImpl extends BaseService<StPptnR, StPptnRDao> implements StPptnRService {

    @Autowired
    private StPptnRDao stPptnRDao;
    @Autowired
    private StStbprpBService stStbprpBService;

    @Override
    public List<StStbprpB> getAllRainStations(String startTime, String endTime) {
        final String dateFormat = "yyyy-MM-dd HH";
        List<StStbprpB> stStbprpBList = stStbprpBService.getAllRainStations();
        Calendar calendar = Calendar.getInstance();
        Date endDate;
        try {
            calendar.setTime(DateUtil.parasDate(startTime, dateFormat));
            endDate = DateUtil.parasDate(endTime + ":59:59", dateFormat + ":mm:ss");
        } catch (ParseException e) {
            throw new RestServiceException("日期参数格式不正确", ErrCodeConstants.ERR_1_ERROR, Constants.API_STATUS_PARAMS_ERR);
        }
        while (calendar.getTime().before(endDate)) {
            Date startStaticTime = calendar.getTime();
            calendar.add(Calendar.MINUTE, 59);
            calendar.add(Calendar.SECOND, 59);
            Date endStaticTime = calendar.getTime();
            for (StStbprpB stStbprpB : stStbprpBList) {
                Map<String, Object> resultMap = stPptnRDao.getRainInfoByTime(stStbprpB.getSTCD(), startStaticTime, endStaticTime);
                SiteRainInfo siteRainInfo = new SiteRainInfo();
                siteRainInfo.setSTCD(stStbprpB.getSTCD());
                siteRainInfo.setStaticTime(DateFormatUtils.format(startStaticTime, dateFormat));
                siteRainInfo.setDRP_AVG(resultMap.get("DRP_AVG") == null ? 0d : CommonUtils.setDoubleScale((BigDecimal) resultMap.get("DRP_AVG"), 1));
                siteRainInfo.setDYP_AVG(resultMap.get("DYP_AVG") == null ? 0d : CommonUtils.setDoubleScale((BigDecimal) resultMap.get("DYP_AVG"), 1));
                siteRainInfo.setINTV_AVG(resultMap.get("INTV_AVG") == null ? 0d : CommonUtils.setDoubleScale((BigDecimal) resultMap.get("INTV_AVG"), 1));
                siteRainInfo.setPDR_AVG(resultMap.get("PDR_AVG") == null ? 0d : CommonUtils.setDoubleScale((BigDecimal) resultMap.get("PDR_AVG"), 1));
            }
            calendar.add(Calendar.SECOND, 1);
        }

        return null;
    }

    @Override
    public StPptnRDao getDao() {
        return stPptnRDao;
    }
}
