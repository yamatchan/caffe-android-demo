caffe-android-demo
==================
An android caffe demo app exploiting caffe pre-trained ImageNet model for image classification  
* This demo app corresponds to Android 5.0 or higher

## Quick Start

### Basic

If you want to have a try on this app, please follow the steps below to get the required stuff:
```shell
# 1. get caffe if you don't have one
git clone https://github.com/BVLC/caffe.git
# 2. download model (bvlc_reference_caffenet is used)
cd caffe
./scripts/download_model_binary.py models/bvlc_reference_caffenet/
# 3. push things to your device
adb shell mkdir -p /sdcard/caffe_mobile/
adb push models/bvlc_reference_caffenet/ /sdcard/caffe_mobile/bvlc_reference_caffenet/
```
If the app crashes, first make sure it is not an out of memory issue - modify deploy.prototxt such that the mini batch size is 1 instead of 10


Android版Caffeデモアプリ
==================
このデモアプリはDeap LearningのフレームワークCaffeの分類器をAndroid上で実行するアプリです．  
事前に学習したImageNetモデルを用いた画像分類を行います．  
※Android 5.0以上に対応

## 導入方法
このデモアプリを実行する前に，以下の手順を実行し，学習済みデータをAndroid端末に保存してください．
```shell
# 1. get caffe if you don't have one
git clone https://github.com/BVLC/caffe.git
# 2. download model (bvlc_reference_caffenet is used)
cd caffe
./scripts/download_model_binary.py models/bvlc_reference_caffenet/
# 3. push things to your device
adb shell mkdir -p /sdcard/caffe_mobile/
adb push models/bvlc_reference_caffenet/ /sdcard/caffe_mobile/bvlc_reference_caffenet/
```
