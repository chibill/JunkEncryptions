import binascii

import decimal

import sys


d = decimal.Decimal


def encode(data):
  return int(binascii.hexlify(data),16)

decimal.getcontext().prec = 99999


def leadingZeros(data):
  zeros = 0
  if(data == "0"):
    return 1
  for x in str(data):
    if x != "0":
      return zeros
    else:
      ++zeros



def encrypt(data,password):
  encodedData = d(encode(data))
  encodedPass = d(encode(password))
  enncrypted = (encodedData / (encodedPass))

  encryptedData = str(enncrypted).split(".")

  if(len(encryptedData) == 1):
    encryptedData.append("0")

  First = encryptedData[0]
  second = encryptedData[1]
  secondZeros = leadingZeros(second)


  FirstBin = First
  SecondBin = second
  SecondZeroBin = secondZeros
  lengthF = len(FirstBin)
  lengthS = len(SecondBin)
  lengthSZ = len(str(SecondZeroBin))
  #print("Encode - DATA: "+data+" Password: "+password +" Encoded Output: "+ str(lengthF) + "." + str(lengthS)+"."+str(lengthSZ)+"."+str(FirstBin)+str(SecondBin)+str(SecondZeroBin) )
  return str(lengthF) + "." + str(lengthS)+"."+str(lengthSZ)+"."+str(FirstBin)+str(SecondBin)+str(SecondZeroBin)
