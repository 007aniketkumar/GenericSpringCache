/**
 * 
 */
package com.ani.util;

import java.math.BigDecimal;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

/**
 * @author aniket
 *
 *
 *Class to test out the # feature provided by spel
 */
@Component
public class SpringExpression {

	static public void expressionEvaluator() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("(T(java.lang.Math).random() * 100.0) ");
		System.out.println(exp.getValue(BigDecimal.class));


	}
}
