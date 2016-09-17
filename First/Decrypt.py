import binascii

import decimal

d = decimal.Decimal



def Decode(data):
  return binascii.unhexlify('%x' % data)

def encode(data):
  return int(binascii.hexlify(data),16)

decimal.getcontext().prec = 99999

def Decrypt(data,password):
  splitdata = data.split(".")

  lengthF = splitdata[0]
  lengthS = splitdata[1]
  lengthSZ = splitdata[2]
  combinedData = splitdata[3]
  First = combinedData[0:int(lengthF)]
  combinedData = combinedData[int(lengthF):]
  Second = combinedData[0:int(lengthS)]
  SecondZ = combinedData[int(lengthS):][0:int(lengthSZ)]

  #First = int(First,2)
  #Second = int(Second,2)
  #SecondZ = int(SecondZ,2)


  Second=  ("0"*int(SecondZ))+str(Second)
  Combined = d(str(First)+"."+str(Second))
  dataout = d(Combined) * d(encode(password))
  print("Decode - DATA: "+data+" Password: "+password +" Decoded Output: "+Decode(int(dataout)))
  return Decode(int(dataout))
