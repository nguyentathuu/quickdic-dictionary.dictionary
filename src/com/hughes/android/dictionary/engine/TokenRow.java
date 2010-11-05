package com.hughes.android.dictionary.engine;

import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class TokenRow extends RowBase {
  
  TokenRow(final RandomAccessFile raf, final int thisRowIndex, final Index index) throws IOException {
    super(raf, thisRowIndex, index);
  }

  TokenRow(final int referenceIndex, final int thisRowIndex, final Index index) {
    super(referenceIndex, thisRowIndex, index);
  }
  
  public String toString() {
    return getToken() + "@" + referenceIndex;
  }

  @Override
  public TokenRow getTokenRow(final boolean search) {
    return this;
  }

  @Override
  public void setTokenRow(TokenRow tokenRow) {
    throw new RuntimeException("Shouldn't be setting TokenRow's TokenRow!");
  }
  
  public String getToken() {
    return index.sortedIndexEntries.get(referenceIndex).token;
  }

  @Override
  public void print(final PrintStream out) {
    out.println(getToken());
  }

  @Override
  public String getRawText(boolean compact) {
    return getToken();
  }


}
