package com.ifsc.secstor.library.testutils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PSSShareModel {
    private List<IndexKeyPair> shares;
    private List<IndexArrayPair> macKeys;
    private List<IndexArrayPair> macs;
    private int originalLength;

    @Override
    public String toString() {
        return "PSSShareModel";
    }
}
