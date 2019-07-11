		<div class="container">

Select age range:
<form>
    <select>
     <c:forEach items="${age}" var="ageValue">
         <form:option value="${ageValue}"><spring:message code="${ageValue}"/></form:option>
     </c:forEach>
    </select>
</form>

</form:select>
<br>
            <p><strong> What is your age range  </p>
            <br/>
              ${customerAge}
           <br/>
           <br/>
            <p><strong> What is your income:  </p>
            <br/>
              ${customerIncome}
           <br/>
           <br/>
           <p><strong> Are you a student: </strong><input type="checkbox" name="student" /></p>
           </br>
             <input type = "submit" value = "Get products"/>
          </body>
              </div>