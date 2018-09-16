package com.flamingo.sell.utils;

import com.flamingo.sell.model.vo.ResultVO;

/***
 * 工具类
 * 封装ResultVO
 */
public class ResultVOUtil {

    /***
     * 成功，返回数据
     * @param object
     * @return
     */
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    /***
     * 成功，不返回数据
     * @return
     */
    public static ResultVO success() {
        return success(null);
    }

    /***
     * 失败，返回错误信息
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
