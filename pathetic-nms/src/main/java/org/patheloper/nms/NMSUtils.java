package org.patheloper.nms;

import org.patheloper.api.snapshot.NMSInterface;
import org.patheloper.nms.v1_12.OneTwelveNMSInterface;
import org.patheloper.nms.v1_15.OneFifteenNMSInterface;
import org.patheloper.nms.v1_16.OneSixteenNMSInterface;
import org.patheloper.nms.v1_17.OneSeventeenNMSInterface;
import org.patheloper.nms.v1_18.OneEighteenNMSInterface;
import org.patheloper.nms.v1_18_R2.OneEighteenTwoNMSInterface;
import org.patheloper.nms.v1_19_R2.OneNineteenTwoNMSInterface;
import org.patheloper.nms.v1_19_R3.OneNineteenThreeNMSInterface;
import org.patheloper.nms.v1_20_R1.OneTwentyOneNMSInterface;
import org.patheloper.nms.v1_20_R2.OneTwentyTwoNMSInterface;
import org.patheloper.nms.v1_20_R3.OneTwentyThreeNMSInterface;
import org.patheloper.nms.v1_20_R4.OneTwentyFourNMSInterface;
import org.patheloper.nms.v1_8.OneEightNMSInterface;

public class NMSUtils {

  private final NMSInterface nmsInterface;

  public NMSUtils(int major, int minor) {
    switch (major) {
      case 20:
        if (minor == 5 || minor == 6) {
          nmsInterface = new OneTwentyFourNMSInterface();
          break;
        } else if (minor == 3 || minor == 4) {
          nmsInterface = new OneTwentyThreeNMSInterface();
          break;
        } else if (minor == 2) {
          nmsInterface = new OneTwentyTwoNMSInterface();
          break;
        } else if (minor == 1) {
          nmsInterface = new OneTwentyOneNMSInterface();
          break;
        }
        throw new IllegalArgumentException("Unsupported version: " + major + "." + minor);
      case 19:
        if (minor == 2 || minor == 3) {
          nmsInterface = new OneNineteenTwoNMSInterface();
          break;
        }
        if (minor == 4) {
          nmsInterface = new OneNineteenThreeNMSInterface();
          break;
        }
        throw new IllegalArgumentException("Unsupported version: " + major + "." + minor);
      case 18:
        if (minor == 2) {
          nmsInterface = new OneEighteenTwoNMSInterface();
          break;
        }
        nmsInterface = new OneEighteenNMSInterface();
        break;
      case 17:
        nmsInterface = new OneSeventeenNMSInterface();
        break;
      case 16:
        nmsInterface = new OneSixteenNMSInterface();
        break;
      case 15:
        nmsInterface = new OneFifteenNMSInterface();
        break;
      case 12:
        nmsInterface = new OneTwelveNMSInterface();
        break;
      case 8:
        nmsInterface = new OneEightNMSInterface();
        break;
      default:
        throw new IllegalArgumentException("Unsupported version: " + major + "." + minor);
    }
  }

  public NMSInterface getNmsInterface() {
    return this.nmsInterface;
  }
}
