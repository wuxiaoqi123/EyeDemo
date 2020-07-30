package com.example.eyedemo

interface Const {

    interface ItemViewType {

        companion object {

            const val UNKNOWN = -1

            const val CUSTOM_HEADER = 0

            const val TEXT_CARD_HEADER1 = 1

            const val TEXT_CARD_HEADER2 = 2

            const val TEXT_CARD_HEADER3 = 3

            const val TEXT_CARD_HEADER4 = 4

            const val TEXT_CARD_HEADER5 = 5

            const val TEXT_CARD_HEADER6 = 6

            const val TEXT_CARD_HEADER7 = 7

            const val TEXT_CARD_HEADER8 = 8

            const val TEXT_CARD_FOOTER1 = 9

            const val TEXT_CARD_FOOTER2 = 10

            const val TEXT_CARD_FOOTER3 = 11

            const val BANNER = 12

            const val BANNER3 = 13

            const val FOLLOW_CARD = 14

            const val TAG_BRIEFCARD = 15

            const val TOPIC_BRIEFCARD = 16

            const val COLUMN_CARD_LIST = 17

            const val VIDEO_SMALL_CARD = 18

            const val INFORMATION_CARD = 19

            const val AUTO_PLAY_VIDEO_AD = 20

            const val HORIZONTAL_SCROLL_CARD = 21

            const val SPECIAL_SQUARE_CARD_COLLECTION = 22

            const val UGC_SELECTED_CARD_COLLECTION = 23

            const val MAX = 100
        }
    }

    interface ActionUrl {

        companion object {
            const val TAG = "eyepetizer://tag/"

            const val DETAIL = "eyepetizer://detail/"

            const val RANKLIST = "eyepetizer://ranklist/"

            const val WEBVIEW = "eyepetizer://webview/?title="

            const val REPLIES_HOT = "eyepetizer://replies/hot?"

            const val TOPIC_DETAIL = "eyepetizer://topic/detail?"

            const val COMMON_TITLE = "eyepetizer://common/?title"

            const val LT_DETAIL = "eyepetizer://lightTopic/detail/"

            const val CM_TOPIC_SQUARE = "eyepetizer://community/topicSquare"

            const val HP_NOTIFI_TAB_ZERO = "eyepetizer://homepage/notification?tabIndex=0"

            const val CM_TAGSQUARE_TAB_ZERO = "eyepetizer://community/tagSquare?tabIndex=0"

            const val CM_TOPIC_SQUARE_TAB_ZERO = "eyepetizer://community/tagSquare?tabIndex=0"

            const val HP_SEL_TAB_TWO_NEWTAB_MINUS_THREE =
                "eyepetizer://homepage/selected?tabIndex=2&newTabIndex=-3"
        }
    }

    interface Toast {
        companion object {
            const val BIND_VIEWHOLDER_TYPE_WARN = "bindViewHolder Type Unprocessed"
        }
    }

    interface Url {

        companion object {

            const val AUTHOR_LOGIN = "http://open.eyepetizer.net/#!/login"

            const val AUTHOR_REGISTER = "http://open.eyepetizer.net/#!/register"

            const val FORGET_PASSWORD = "http://open.eyepetizer.net/#!/forget"

            const val USER_AGREEMENT = "http://www.eyepetizer.net/agreement.html"

            const val VIDEO_FUNCTION_STATEMENT = "http://www.eyepetizer.net/right.html"

            const val LEGAL_NOTICES = "http://www.kaiyanapp.com/legal_notices.html"

            const val AUTHOR_OPEN = "http://open.eyepetizer.net/#!/landing"
        }
    }

    interface Mobclick {

        companion object {

            const val EVENT1 = "10001"

            const val EVENT2 = "10002"

            const val EVENT3 = "10003"

            const val EVENT4 = "10004"

            const val EVENT5 = "10005"

            const val EVENT6 = "10006"

            const val EVENT7 = "10007"

            const val EVENT8 = "10008"

            const val EVENT9 = "10009"
        }
    }
}