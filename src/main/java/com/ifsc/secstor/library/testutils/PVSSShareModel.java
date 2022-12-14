package com.ifsc.secstor.library.testutils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PVSSShareModel {
    private List<IndexKeyPair> shares;
    private int shareOriginalLength;
    private String key;
    private int keyOriginalLength;
    private BigInteger modulus;
    private int modulusOriginalLength;
}
