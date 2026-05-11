import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Area1")
public class Area1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter p = response.getWriter();
        
        String radiuss = request.getParameter("radius");
        
        try {
            float r1 = Float.parseFloat(radiuss);
            float area = 3.14159f * r1 * r1;
            
            p.println("<!DOCTYPE html>");
            p.println("<html lang='en'>");
            p.println("<head>");
            p.println("    <meta charset='UTF-8'>");
            p.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            p.println("    <title>Result | Circle.io</title>");
            p.println("    <style>");
            p.println("        :root { --bg: #f8fafc; --card: #ffffff; --primary: #2563eb; --text-heading: #0f172a; --text-body: #475569; --border: #e2e8f0; }");
            p.println("        * { margin: 0; padding: 0; box-sizing: border-box; font-family: 'Segoe UI', system-ui, sans-serif; }");
            p.println("        body { background-color: var(--bg); color: var(--text-body); min-height: 100vh; display: flex; justify-content: center; align-items: center; }");
            p.println("        .container { width: 100%; max-width: 400px; padding: 20px; }");
            p.println("        header { text-align: center; margin-bottom: 32px; }");
            p.println("        header h1 { font-size: 2rem; color: var(--primary); font-weight: 800; }");
            p.println("        .card { background: var(--card); border: 1px solid var(--border); border-radius: 12px; padding: 40px; box-shadow: 0 10px 15px -3px rgba(0,0,0,0.1); text-align: center; }");
            p.println("        .result-value { font-size: 3.5rem; font-weight: 800; color: #16a34a; margin: 24px 0; }");
            p.println("        .back-btn { display: inline-block; margin-top: 24px; color: var(--primary); text-decoration: none; font-weight: 600; }");
            p.println("        footer { margin-top: 24px; text-align: center; color: #94a3b8; font-size: 0.8rem; }");
            p.println("    </style>");
            p.println("</head>");
            p.println("<body>");
            p.println("    <div class='container'>");
            p.println("        <header><h1>Circle.io</h1></header>");
            p.println("        <div class='card'>");
            p.println("            <h2 style='font-size: 1.25rem; color: var(--text-heading);'>Calculation Result</h2>");
            p.println("            <p style='margin-top: 12px;'>Radius: <strong>" + r1 + " cm</strong></p>");
            p.println("            <div class='result-value'>" + String.format("%.2f", area) + "</div>");
            p.println("            <p>Square Centimeters</p>");
            p.println("            <a href='./' class='back-btn'>&larr; Calculate Another</a>");
            p.println("        </div>");
            p.println("        <footer><p>&copy; 2024 Circle Geometry Tools</p></footer>");
            p.println("    </div>");
            p.println("</body>");
            p.println("</html>");
            
        } catch (Exception e) {
            p.println("<html><body><div style='text-align:center; padding: 50px;'><h2>Error</h2><p>Invalid Input.</p><a href='./'>Go Back</a></div></body></html>");
        }
    }
}
