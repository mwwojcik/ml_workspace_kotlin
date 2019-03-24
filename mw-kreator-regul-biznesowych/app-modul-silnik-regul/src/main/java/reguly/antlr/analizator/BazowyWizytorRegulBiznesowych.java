package reguly.antlr.analizator;

import org.antlr.v4.runtime.tree.*;
import reguly.antlr.gen.RegulyBiznesoweBaseVisitor;

public class BazowyWizytorRegulBiznesowych<T> extends RegulyBiznesoweBaseVisitor<T> implements ParseTreeVisitor<T> {

    public T visit(ParseTree tree) {
        return tree.accept(this);
    }

    public T visitChildren(RuleNode node) {
        T result = this.defaultResult();
        int n = node.getChildCount();

        for (int i = 0; i < n && this.shouldVisitNextChild(node, result); ++i) {
            ParseTree c = node.getChild(i);
            T childResult = c.accept(this);
            result = this.aggregateResult(result, childResult);
        }

        return result;
    }

    public T visitTerminal(TerminalNode node) {
        return (T) node.getText();
    }

    public T visitErrorNode(ErrorNode node) {
        return this.defaultResult();
    }

    protected T defaultResult() {
        return null;
    }

    protected T aggregateResult(T aggregate, T nextResult) {
        StringBuilder pSB = new StringBuilder();
        if (aggregate != null) {
            pSB.append(aggregate);
        }

        if(aggregate!=null&&nextResult!=null){
            if(!(aggregate.equals(")")||nextResult.equals(")")||aggregate.equals("(")||nextResult.equals("("))) {
                pSB.append(" ");
            }
        }

        if (nextResult != null) {
            pSB.append(nextResult);
        }
        return (T) pSB.toString();
    }

    protected boolean shouldVisitNextChild(RuleNode node, T currentResult) {
        return true;
    }
}