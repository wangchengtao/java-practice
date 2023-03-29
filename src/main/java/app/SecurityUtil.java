package app;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class SecurityUtil {
    public static void main(String[] args) {
        Map<String, String> param = new HashMap<>();
        param.put("partner", "401570000599");
        param.put("data", "");
        param.put("charset", "UTF-8");
        param.put("dataType", "xml");
        param.put("serviceName", "pic_upload");
        param.put("signType", "md5");
        System.out.println(sign(param, "md5", "936a9824a59427f23239a1079d3cddc9", "UTF-8"));
    }

    public static String sign(Map<String, String> params, String signType, String secretKey, String charset) {
        params = paramsFilter(params);
        String prestr = createLinkString(params); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
        prestr = prestr + secretKey; // 把拼接后的字符串再与安全校验码直接连接起来
        String sign = "";
        if ("md5".equalsIgnoreCase(signType)) {
            sign = md5(prestr, charset);
        }
        return sign;
    }

    private static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        StringBuilder prestr = new StringBuilder();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr.append(key).append("=").append(value);
            } else {
                prestr.append(key).append("=").append(value).append("&");
            }
        }

        return prestr.toString();
    }

    private static Map<String, String> paramsFilter(Map<String, String> params) {
        Map<String, String> result = new HashMap<>();

        if (params == null || params.size() <= 0) {
            return result;
        }

        for (String key : params.keySet()) {
            String value = params.get(key);
            if (StringUtils.isEmpty(value)
                    || key.equalsIgnoreCase("dataSign")
                    || key.equalsIgnoreCase("signType")
            ) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    public static String md5(String text, String charset) {
        return DigestUtils.md5Hex(getContentBytes(text, charset));
    }

    private static byte[] getContentBytes(String text, String charset) {
        if (charset == null || "".equals(charset)) {
            return text.getBytes();
        }

        try {
            return text.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "".getBytes();
    }
}
