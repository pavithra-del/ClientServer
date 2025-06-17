import java.io.*;
import java.net.*;

public class SocketHTTPClient1 {
    public static void main(String[] args) {
        try {
            
            Socket socket = new Socket("www.martinbroadhurst.com", 80);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("GET / HTTP/1.1");
            out.println("Host: www.martinbroadhurst.com");
            out.println("User-Agent: JavaSocketClient/1.0");
            out.println("Connection: close"); 
            out.println();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            boolean isBody = false;

            System.out.println("----- HTTP Response Start -----");
            while ((line = in.readLine()) != null) {
                if (line.isEmpty()) {
                    isBody = true;
                    System.out.println("----- Body Start -----");
                    continue;
                }
                if (!isBody) {
                    System.out.println("Header: " + line);
                } else {
                    System.out.println(line);
                }
            }
            System.out.println("----- HTTP Response End -----");

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
Output:
Header: HTTP/1.1 403 Forbidden
Header: Server: nginx
Header: Date: Tue, 17 Jun 2025 09:06:56 GMT
Header: Content-Type: text/html; charset=utf-8
Header: Content-Length: 2641
Header: Connection: close
Header: Vary: Accept-Encoding
Header: Last-Modified: Wed, 23 Apr 2025 08:42:25 GMT
Header: ETag: "a51-6336e149610a7"
Header: Accept-Ranges: bytes
----- Body Start -----
<!doctype html>
<html lang="en">
        <head>
                <meta charset="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <title>Access Denied</title>
                <style>
                        body {
                                background-color: #f5f5f5;
                                margin-top: 8%;
                                color: #5d5d5d;
                                font-family:
                                        -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial,
                                        "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol",
                                        "Noto Color Emoji";
                                text-shadow: 0px 1px 1px rgba(255, 255, 255, 0.75);
                                text-align: center;
                        }
----- Body Start -----
                        h1 {
                                font-size: 2.45em;
                                font-weight: 700;
                                color: #5d5d5d;
                                letter-spacing: -0.02em;
                                margin-bottom: 30px;
                                margin-top: 30px;
                        }
----- Body Start -----
                        .container {
                                width: 100%;
                                margin-right: auto;
                                margin-left: auto;
                        }
----- Body Start -----
                        .animate__animated {
                                animation-duration: 1s;
                                animation-fill-mode: both;
                        }
----- Body Start -----
                        .animate__fadeIn {
                                animation-name: fadeIn;
                        }
----- Body Start -----
                        .info {
                                color: #5594cf;
                                fill: #5594cf;
                        }
----- Body Start -----
                        .error {
                                color: #c92127;
                                fill: #c92127;
                        }
----- Body Start -----
                        .warning {
                                color: #ffcc33;
                                fill: #ffcc33;
                        }
----- Body Start -----
                        .success {
                                color: #5aba47;
                                fill: #5aba47;
                        }
----- Body Start -----
                        .icon-large {
                                height: 132px;
                                width: 132px;
                        }
----- Body Start -----
                        .description-text {
                                color: #707070;
                                letter-spacing: -0.01em;
                                font-size: 1.25em;
                                line-height: 20px;
                        }
----- Body Start -----
                        .footer {
                                margin-top: 40px;
                                font-size: 0.7em;
                        }
----- Body Start -----
                        @keyframes fadeIn {
                                from {
                                        opacity: 0;
                                }
                                to {
                                        opacity: 1;
                                }
                        }
                </style>
        </head>
        <body>
                <div class="container">
                        <div class="row">
                                <div class="col">
                                        <div class="animate__animated animate__fadeIn">
                                                <svg
                                                        class="error icon-large fa-times-circle"
                                                        xmlns="http://www.w3.org/2000/svg"
                                                        viewBox="0 0 512 512"
                                                >
                                                        <path
                                                                d="M256 8C119 8 8 119 8 256s111 248 248 248 248-111 248-248S393 8 256 8zm121.6 313.1c4.7 4.7 4.7 12.3 0 17L338 377.6c-4.7 4.7-12.3 4.7-17 0L256 312l-65.1 65.6c-4.7 4.7-12.3 4.7-17 0L134.4 338c-4.7-4.7-4.7-12.3 0-17l65.6-65-65.6-65.1c-4.7-4.7-4.7-12.3 0-17l39.6-39.6c4.7-4.7 12.3-4.7 17 0l65 65.7 65.1-65.6c4.7-4.7 12.3-4.7 17 0l39.6 39.6c4.7 4.7 4.7 12.3 0 17L312 256l65.6 65.1z"
                                                        ></path>
                                                </svg>
                                        </div>
                                        <h1 class="animate__animated animate__fadeIn">Access Denied</h1>
                                        <div class="description-text animate__animated animate__fadeIn">
                                                <p>You do not have permission to view this page.</p>
                                                <p>Please check your credentials and try again.</p>
                                                <section class="footer"><strong>Error Code:</strong> 403</section>
                                        </div>
                                </div>
                        </div>
                </div>
        </body>
</html>
----- HTTP Response End -----

