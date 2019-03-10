package io.github.mysql.utils;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.misc.Interval;

@Slf4j
public class UpperCaseCharStream implements CharStream {

    private CodePointCharStream wrapped;

    public UpperCaseCharStream(CodePointCharStream wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void consume() {
        wrapped.consume();
    }

    @Override
    public int LA(int i) {
        int la = wrapped.LA(i);
        if(la == 0 || la == IntStream.EOF) {
            return la;
        } else {
            return Character.toUpperCase(la);
        }
    }

    @Override
    public String getText(Interval interval) {
        if (size() > 0 && (interval.b - interval.a >= 0)) {
            String str = wrapped.getText(interval);
            log.trace("str:{}",str);
            return str;
        } else {
            return "";
        }
    }

    @Override
    public int mark() {
        return wrapped.mark();
    }

    @Override
    public void release(int i) {
        wrapped.release(i);
    }

    @Override
    public int index() {
        return wrapped.index();
    }

    @Override
    public void seek(int i) {
        wrapped.seek(i);
    }

    @Override
    public int size() {
        return wrapped.size();
    }

    @Override
    public String getSourceName() {
        return wrapped.getSourceName();
    }
}