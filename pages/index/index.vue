<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>
		<view>
			<button type = "primary" @click="voiceInput()">语音输入</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {

		},
		methods: {
			voiceInput:function(){
				const voiceRecognizer = swan.ai.getVoiceRecognizer();
				voiceRecognizer.onStart(() => {
				    console.log('voice start');
				});
				voiceRecognizer.onRecognize(res => {
				    console.log('voice recognize', res);
				});
				voiceRecognizer.onFinish(res => {
				    console.log('voice end', res);
				});
				voiceRecognizer.onError(err => {
				    console.log('voice error', err);
				});
				const options = {
				    mode: 'dnn',
				    longSpeech: false
				};
				voiceRecognizer.start(options);
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
