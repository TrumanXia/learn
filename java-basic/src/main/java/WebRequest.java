import jdk.nashorn.internal.ir.CallNode;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import javax.jws.Oneway;
import java.io.*;
import java.nio.CharBuffer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author 97994
 * @since 2020-10-18
 */
public class WebRequest {
    Set<String> triedRandomCodes = new HashSet<>();

    public static void main(String[] args) throws IOException, InterruptedException {

        // charBuffer 如何使用？
        // CharBuffer allocatedBuffer = CharBuffer.allocate(1024);
        // int read = new InputStreamReader(content).read(allocatedBuffer);
        // System.out.println(allocatedBuffer.g);
        while (true) {
            WebRequest webRequest = new WebRequest();
            webRequest.tryOneUrl();
        }
        // for (int i = 0; i < 60; i++) {
        // WebRequest webRequest = new WebRequest();
        // webRequest.tryOneUrl();
        //// Thread.sleep(1_000);
        // }
    }

    private void tryOneUrl() throws IOException {
        File file = new File("E:\\Projects\\java\\learn\\java-basic\\src\\main\\resources\\validUrl.txt");
        FileWriter fileWriter = new FileWriter(file);
        String randomUrl = createRandomUrl();
        System.out.println(randomUrl);
        HttpGet httpGet = new HttpGet(randomUrl);
        // CloseableHttpResponse response = HttpClients.createDefault().execute(
        // new HttpHost("https://play.520520bo.com/20200502/avQGpBrQ/index.m3u8"), new HttpGet(), (HttpContext)null);
        CloseableHttpResponse response = HttpClients.createDefault().execute(httpGet);
        StatusLine statusLine = response.getStatusLine();
        InputStream content = response.getEntity().getContent();
        char[] chars = new char[1024];
        int read = new InputStreamReader(content).read(chars);
        System.out.println(new String(chars));
        if (statusLine.getStatusCode() == 200 && !"resource not found".equals(new String(chars).trim())) {
            String goodResult = "good - " + randomUrl;
            System.out.println(goodResult);
            fileWriter.write(goodResult);
            fileWriter.flush();
        }
    }

    private String createRandomUrl() {
        // https://play.520520bo.com/20200502/avQGpBr/index.m3u8
        // resource not found
        String baseUrl = "https://play.520520bo.com/%s/%s/index.m3u8";
        // 9月份
        // LocalDate endDate = LocalDate.now().plusDays(1);
        LocalDate startDate = LocalDate.now().minusDays(31);

        String specificDate = decorate(startDate.toString());
        // System.out.println(specificDate);
        // System.out.println(RandomCodeHelper.generateCode());
        // System.out.println(RandomCodeHelper.generateCode());
        // System.out.println(RandomCodeHelper.generateCode());
        // System.out.println(RandomCodeHelper.generateCode());
        // System.out.println(decorate(endDate.toString()));
        String code = RandomCodeHelper.generateCode();
        while (triedRandomCodes.contains(code)) {
            code = RandomCodeHelper.generateCode();
        }

        return String.format(baseUrl, "20200502", code);
        // return String.format(baseUrl, "20200502", "avQGpBrQ");
    }

    // public

    // private String generateRandomCode() {
    // char a = 48;
    //// 48 - 57; 65 - 90; 97 - 122
    // int digitsNum = 10;
    // int upperCaseLetterNum = 26;
    // int lowerCaseLetterNum = 26;
    // Random random = new Random();
    // char randomDigit = (char)(random.nextInt(digitsNum) + 48);
    // char randomUpperCaseLetter = (char)(random.nextInt(upperCaseLetterNum) + 65);
    // char randomLowerCaseLetter = (char)(random.nextInt(lowerCaseLetterNum) + 97);
    // char[] resourcePool = {randomDigit, randomLowerCaseLetter, randomUpperCaseLetter};
    // char[] randomCodeChars = new char[8];
    // for (int i = 0; i < 8; i++) {
    // randomCodeChars[i] = resourcePool[random.nextInt(3)];
    // }
    // return new String(randomCodeChars);
    // }
    private String decorate(String original) {
        return original.replace("-", "");
    }
}
